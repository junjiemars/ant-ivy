package org.tao;
import static java.lang.System.out;
import java.lang.System;
import gnu.getopt.Getopt;
import org.jivesoftware.smack.*;
import org.jivesoftware.smack.packet.*;
import org.jivesoftware.smackx.*;
import java.io.Console;
import java.util.regex.*;
import java.util.Collection;

public class Jabber {
	public static final void main(String[] args) {
		Getopt g = new Getopt("jabber", args, "j:p:t:h:i:r:");
		int c;
		String jid = null, tojid = null;
		String passwd = null;
        String host = null;
        int port = 5222;
        String resource = System.getenv("HOSTNAME");

		while (-1 != (c = g.getopt())) {
			switch (c) {
				case 'j':
					jid = g.getOptarg();
					break;
				case 'p':
					passwd = g.getOptarg();
					break;
                case 'h':
                    host = g.getOptarg();
                    break;
                case 'i':
                    port = Integer.parseInt(g.getOptarg());
                    break;
                case 'r':
                    resource = g.getOptarg();
                    break;
                case 't':
                    tojid = g.getOptarg();
                    break;
				case '?':
					break; // getopt() already printed an error
				default:
					help();
					break;
			}
		}
		debug("$jid:%s passwd:%s resource:%s tojid:%s host:%s port:%s", jid, passwd, resource, tojid, host, port);

		ConnectionConfiguration config = new ConnectionConfiguration(host, port, resource);
		config.setSASLAuthenticationEnabled(true);
        config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);

		_connection = new XMPPConnection(config);
        _connection.DEBUG_ENABLED = true;
		try {
			_connection.connect();
            listen_packet(_connection);
			_connection.login(jid, passwd, resource);
		} catch (Exception e) {
			error(e);
		} finally {
			//;
		}

//     	final Console in = System.console();
//		Matcher p = readln(in);

        for (int i = 0; i < 100; i++) {
            String now = Long.toString(System.currentTimeMillis());
            debug("$now:%s", now);
            sayto(_connection, tojid, now);
            try {
                Thread.sleep(10000);
            } catch (Exception e) {
                error(e);
            }
        }

//		while (true) {		
//			if (p.find()) {
//				final String op = p.group(1);
//
//				if ("/sayto".equals(op)) {
//					sayto(_connection, str_trim(p.group(2))/*jid*/, str_trim(p.group(3))/*msg*/);
//				} else if ("/quit".equals(op)) {
//					debug("$ GAME OVER...");
//					System.exit(0);
//				} else if ("/listen".equals(op)) {
//					//listen(_connection);
//                    listen_notification(_connection);
//                } else if ("/lpacket".equals(op)) { 
//                    listen_packet(_connection);
//				} else if ("/reply".equals(op)) {
//					//do nothing just wait input	
//				} else if ("/roster".equals(op)) {
//					roster(_connection);
//				} else {
//					debug("$unknown command:%s", op);
//				}
//			} else {
//				debug("$unknown command");
//			}
//
//			p = readln(in);
//		}
	}

	private static final Matcher readln(final Console c) {
		final String s = c.readLine("$command:\n");
		Matcher p = _op.matcher(s);
		return (p);
	}

	private static final void listen(final XMPPConnection conn) {
		final ChatManager mgr = conn.getChatManager();
		mgr.addChatListener(
			new ChatManagerListener() {
				@Override
				public void chatCreated(final Chat chat, boolean createdLocally) {
					chat.addMessageListener(new MessageListener() {
						public void processMessage(Chat c, Message m) {
							debug("$from:%s\n%s", c.getParticipant(), m.toXML());
							final String s = System.console().readLine();
							say(c, s);
						}
					});
				}
			}
		);
	}

    private static final void listen_packet(final XMPPConnection conn) {
        final PacketListener l = new PacketListener() {
            @Override
            public void processPacket(final Packet p) {
                debug("$listen_packet start: pid=%s", p.getPacketID());
                debug("$listen_packet toxml:%s", p.toXML());
                for (PacketExtension e : p.getExtensions()) {
                    debug("%s", e.toXML());
                }
                debug("$listen_packet end: pid=%s", p.getPacketID());
            }
        };

        conn.addPacketListener(l, null);
    }

    private static final void listen_notification(final XMPPConnection conn) {
       _messageEventManager = new MessageEventManager(conn);
       _messageEventManager.addMessageEventRequestListener(new DefaultMessageEventRequestListener() {
        public void deliveredNotificationRequested(String from, String pid, MessageEventManager e) {
           super.deliveredNotificationRequested(from, pid, e);
           debug("#delivered: from=%s, pid=%s, e=%s", from, pid, e);
        }
        public void displayedNotificationRequested(String from, String pid, MessageEventManager e) {
            super.displayedNotificationRequested(from, pid, e);
            debug("#displayed: from=%s, pid=%s, e=%s", from, pid, e);
        }
        public void composingNotificationRequested(String from, String pid, MessageEventManager e) {
            super.composingNotificationRequested(from, pid, e);
            debug("#composing: from=%s, pid=%s, e=%s", from, pid, e);
        }
        public void offlineNotificationRequested(String from, String pid, MessageEventManager e) {
            super.offlineNotificationRequested(from, pid, e);
            debug("#offline: from=%s, pid=%s, e=%s", from, pid, e);
        }
       });
    }

	private static final void say(final Chat c, final String s) {
		final Message m = new Message();
		m.setBody(s);
		say(c, m);
	}

	private static final void say(final Chat c, final Message m) {
		try {
            //MessageEventManager.addNotificationsRequests(m, true, true, true, true);
            debug("$message:%s", m.toXML());
			c.sendMessage(m);
		} catch (XMPPException e) {
			debug("$send_failed:%s", e);
		}
	}

	private static final void sayto(final XMPPConnection conn, final String jid, final String msg) {
		if (conn == null || !conn.isConnected()) {
			debug("$sayto:%s", "no-connection existing");
			return;
		}

        debug("$sayto: conn=%s, jid=%s, msg=%s", conn, jid, msg);
		final ChatManager mgr = conn.getChatManager();
		final Chat chat = mgr.createChat(jid, new MessageListener() {
		    public void processMessage(Chat c, Message m) {
				debug("{ $from:%s\n%s\n}", jid, m.toXML());
		    }
		});

		say(chat, msg);
	}

	private static final void roster(final XMPPConnection conn) {
		final Roster roster = conn.getRoster();
		final Collection<RosterEntry> entries = roster.getEntries();

		for (RosterEntry entry : entries) {
			debug("$roster:%s", entry);
		}
	}
	
	private static final String str_trim(final String s) {
		if (null == s) 
			return ("");
		
		return (s.trim());
	}

	private static final String str_format(final String f, final Object... s) {
		if (null == f) 
			return ("");

		return (String.format(f, s));
	}
	
    private static final void error(final Exception e) {
        out.println(str_format("$error:%s", e));
    }

	private static final void error(final XMPPException e) {
        out.println(str_format("$error:%s", e));
	}

	private static final void debug(final String f, final Object... s) {
		out.println(str_format(f, s));
	}

    private static final void help() {
        debug("Jabber {-j|-jid} {-p|-passwd} [-r|resource] {-h|-host} [-i|-port]");
    }

	private final static Pattern _op = Pattern.compile("(/\\w+)( +\\w+@\\w+\\.\\w+)?( +.*)?");

    private static MessageEventManager _messageEventManager;
    private static XMPPConnection _connection;
}

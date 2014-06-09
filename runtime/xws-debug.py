#!/usr/bin/env python
# -*- coding: utf-8 -*-

import json, urllib
import getopt
import sys

host = 'localhost'
port = 8080
system = -1
category = -1
action = 'query'
text = ''
pstart = 0
psize = 5
pmax = 10
retry = 1
mobile = '13914723686'
brand = 'qqt'
city = 'njdq'
debug = False
verbose = False

def debug_output(*msg):
	if debug:
		print '+', msg

def make_url():
	url = 'http://' + host + ':' + str(port) + '/xws/' + action
	return (url)	

def make_appinfo_arg():
	a = { 'request': system }
	
	j = json.dumps(a)
	debug_output('appinfo [json]:', j)

	r = urllib.urlencode({'adminArg': j})
	debug_output('appinfo [urlencoded]:', r)

	return (r)

def make_query_arg():
	mobile = "13914723686"
	brand = "dgdd"
	city = "njdq"

	qa = { 'appArg': {
				'systemId': system,
				'categoryId': category
				},
			'queryText': text,
			'pageSize': psize,
			'maxPages': 1,
			'startPage': pstart,
			'clientArg': {
				'mobile': mobile,
				'brand': brand,
				'city': city
			}
		}

	j = json.dumps(qa)
	debug_output('query [json]:', j)

	r = urllib.urlencode({'queryArg': j})
	if verbose:
		debug_output('query [urlencoded]:', r)

	return (r)

def make_build_arg(mode = True):
	ba = {  'create': mode, 
			'appArg': {
				'systemId': system,
				'categoryId': category
			}
		}

	j = json.dumps(ba)
	debug_output('build [json]:', j)

	r = urllib.urlencode({'adminArg': j})
	if verbose:
		debug_output('build [urlencoded]:', r)

	return (r)
	
def post(url, arg, sn):
	c = 200;

	try:
		q = urllib.urlopen(url, arg)
		c = q.getcode()

		if 200 == c:
			s = q.read()
			j = json.loads(s)
			c = j['status']			
			print '%[ok/', str(sn), ']', s
		else:
			print '%[error/', str(sn), '] http code:', c
	except IOError as eio:
		print 'i/o {0}: {1}'.format(eio.errno, eio.strerror)
	else:
		q.close()
	return (c)

def main():
	global host, port, system, category, action
	global text, pstart, psize, pmax, retry
	global debug

	try:
		opts, args = getopt.getopt(sys.argv[1:], 
			'h:p:s:c:a:t:m:b:z:0:1:2:f:l:r:dv', 
			['host=','port=','system=','category=','action=','text=','startpage=','pagesize=','maxpage=','file=','loop=','retry=','debug','verbose'])
	except getopt.GetoptError, err:
		print str(err)
		sys.exit(2)
	
	for o, a in opts:
		if o in ('-h', '--host'):
			host = a
		elif o in ('-p', '--port'):
			port = a
		elif o in ('-s', '--system'):
			system = a
		elif o in ('-c', '--category'):
			category = a
		elif o in ('-a', '--action'):
			action = a
		elif o in ('-t', '--text'):
			text = a
		elif o in ('-0', '--startpage'):
			pstart = int(a)
		elif o in ('-1', '--pagesize'):
			psize = int(a)	
		elif o in ('-2', '--maxpage'):
			pmax = int(a)
		elif o in ('-r', '--retry'):
			retry = int(a)
		elif o in ('-d', '--debug'):
			debug = True
		elif o in ('-v', '--verbose'):
			verbose = True
		else:
			assert False, 'unhandled option'
	
	debug_output(sys.argv)
	debug_output(str.format("host:{0} port:{1} system:{2} category:{3} action:{4} text:{5} startpage:{6} pagesize:{7}", 
		host, port, system, category, action, text, pstart, psize))

	url = make_url()
	debug_output('calling [url]:', url)

	arg = None
	if 'query' == action:
		arg = make_query_arg()
	elif 'appInfo' == action:
		arg = make_appinfo_arg()
	elif 'build' == action:
		arg = make_build_arg()
	else:
		debug_output('unhandled action ', action)
		sys.exit(1)

	for i in range(retry):
		r = post(url, arg, i)
		if 0 == r:
			break

	
if __name__ == "__main__":
	main()

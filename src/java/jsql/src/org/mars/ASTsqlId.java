package org.mars;

public class ASTsqlId extends SimpleNode {

  public ASTsqlId(int id) {
    super(id);
  }

  public final void setName(String n) {
    _name = n;
  }

  public final String toString() {
    return ("ID: " + _name);
  }

  private String _name;
}

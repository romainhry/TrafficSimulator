package model;

import com.google.common.base.Objects;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import model.PositionedObjects;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class GraphNode {
  private ArrayList<GraphNode> neighbourNodes;
  
  private ArrayList<GraphNode> conflictNodes;
  
  /**
   * Nodes that may cause a problem, so i need to have a perception of them
   */
  private ArrayList<GraphNode> frontNeighbourNodes;
  
  private ArrayList<GraphNode> backNeighbourNodes;
  
  private float length;
  
  private ArrayList<PositionedObjects> posObj;
  
  private float maxDesviationRight;
  
  private float maxDesviationLeft;
  
  public Boolean itIsEmptyNode() {
    boolean _isEmpty = this.posObj.isEmpty();
    if (_isEmpty) {
      return Boolean.valueOf(true);
    } else {
      return Boolean.valueOf(false);
    }
  }
  
  public boolean itHasNeighbour() {
    boolean _isEmpty = this.neighbourNodes.isEmpty();
    if (_isEmpty) {
      return false;
    } else {
      return true;
    }
  }
  
  public boolean itHasConflictNodes() {
    boolean _isEmpty = this.conflictNodes.isEmpty();
    if (_isEmpty) {
      return true;
    } else {
      return false;
    }
  }
  
  public boolean itHasFrontNeighbour() {
    boolean _isEmpty = this.frontNeighbourNodes.isEmpty();
    if (_isEmpty) {
      return false;
    } else {
      return true;
    }
  }
  
  public boolean itHasBackNeighbour() {
    boolean _isEmpty = this.backNeighbourNodes.isEmpty();
    if (_isEmpty) {
      return false;
    } else {
      return true;
    }
  }
  
  @Pure
  public Boolean isNeighbour(final GraphNode node) {
    for (final GraphNode n : this.neighbourNodes) {
      boolean _equals = Objects.equal(n, node);
      if (_equals) {
        return Boolean.valueOf(true);
      }
    }
    return Boolean.valueOf(false);
  }
  
  public boolean add(final GraphNode node) {
    boolean _xblockexpression = false;
    {
      this.neighbourNodes.add(node);
      _xblockexpression = node.neighbourNodes.add(this);
    }
    return _xblockexpression;
  }
  
  @Pure
  public Boolean isEmptyAt(final float x, final float len) {
    for (final PositionedObjects o : this.posObj) {
      {
        if ((((o.getPosition().getX() + o.getLength()) < (x + len)) && ((o.getPosition().getX() + o.getLength()) > (x - len)))) {
          return Boolean.valueOf(false);
        }
        if ((((o.getPosition().getX() - o.getLength()) < (x + len)) && ((o.getPosition().getX() - o.getLength()) > (x - len)))) {
          return Boolean.valueOf(false);
        }
        if ((((o.getPosition().getX() + o.getLength()) > (x + len)) && ((o.getPosition().getX() - o.getLength()) < (x - len)))) {
          return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
      }
    }
    return null;
  }
  
  public PositionedObjects objectAt(final float x) {
    for (final PositionedObjects o : this.posObj) {
      if ((((o.getPosition().getX() - o.getLength()) <= x) && (x <= (o.getPosition().getX() + o.getPosition().getX())))) {
        return o;
      }
    }
    return null;
  }
  
  @Pure
  public ArrayList<PositionedObjects> getPosObj() {
    return this.posObj;
  }
  
  @Pure
  public float getLength() {
    return this.length;
  }
  
  @Pure
  public ArrayList<GraphNode> getFrontNeighbourNodes() {
    return this.frontNeighbourNodes;
  }
  
  @Pure
  public ArrayList<GraphNode> getBackNeighbourNodes() {
    return this.backNeighbourNodes;
  }
  
  public GraphNode nextNode(final int n) {
    return this.frontNeighbourNodes.get(n);
  }
  
  @SyntheticMember
  public GraphNode() {
    super();
  }
}

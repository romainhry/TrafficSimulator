package model.road;

import io.sarl.lang.annotation.SarlSpecification;
import model.GraphNode;
import model.math.Point2f;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class PositionOnTheGraph {
  /**
   * This class will give us a better knowing of a position in all the graph.
   * It has 2 variables : the graph Node on a the Graph and position on this Graph Node
   */
  private Point2f position;
  
  private GraphNode graphNode;
  
  public PositionOnTheGraph(final Point2f p, final GraphNode gn) {
    this.position = p;
    this.graphNode = gn;
  }
  
  @Pure
  public Point2f getPosition() {
    return this.position;
  }
  
  @Pure
  public GraphNode getGraphNode() {
    return this.graphNode;
  }
  
  public Point2f setPosition(final Point2f p) {
    return this.position = p;
  }
  
  public GraphNode setGraphNode(final GraphNode g) {
    return this.graphNode = g;
  }
}

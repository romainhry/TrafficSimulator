package model;

import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import model.GraphNode;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class Graph {
  private ArrayList<GraphNode> nodes;
  
  public boolean add(final GraphNode g) {
    return this.nodes.add(g);
  }
  
  @Pure
  public ArrayList<GraphNode> getNodes() {
    return this.nodes;
  }
  
  @SyntheticMember
  public Graph() {
    super();
  }
}

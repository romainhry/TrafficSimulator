import com.google.common.base.Objects;
import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class GraphNode {
  private ArrayList<GraphNode> neighbourNodes;
  
  private ArrayList<GraphNode> conflictNodes;
  
  /**
   * Nodes that may cause a problem, so i need to have a perception of them
   */
  private float lenght;
  
  private ArrayList<EnvObjects> envObj;
  
  private float maxDesviationRight;
  
  private float maxDesviationLeft;
  
  public Boolean itIsEmptyNode() {
    boolean _isEmpty = this.envObj.isEmpty();
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
    return null;
  }
  
  @SyntheticMember
  public GraphNode() {
    super();
  }
}

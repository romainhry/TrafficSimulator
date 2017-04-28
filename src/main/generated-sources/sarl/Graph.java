import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import java.util.ArrayList;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class Graph {
  private ArrayList<GraphNode> nodes;
  
  @SyntheticMember
  public Graph() {
    super();
  }
}

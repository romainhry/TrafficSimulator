package model.Car;

import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import model.PositionedObjects;
import org.eclipse.xtext.xbase.lib.Pure;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class AgentBody extends PositionedObjects {
  private float frustum;
  
  @Pure
  public float getFrustum() {
    return this.frustum;
  }
  
  @SyntheticMember
  public AgentBody() {
    super();
  }
}

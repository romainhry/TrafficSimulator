package model;

import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Address;
import io.sarl.lang.core.Event;

@SarlSpecification("0.5")
@SuppressWarnings("all")
public class TimeStep extends Event {
  @SyntheticMember
  public TimeStep() {
    super();
  }
  
  @SyntheticMember
  public TimeStep(final Address source) {
    super(source);
  }
  
  @SyntheticMember
  private final static long serialVersionUID = 588368462L;
}

package model;

import io.sarl.lang.annotation.SarlSpecification;
import io.sarl.lang.annotation.SyntheticMember;
import io.sarl.lang.core.Agent;
import io.sarl.lang.core.BuiltinCapacitiesProvider;
import java.util.UUID;
import javax.inject.Inject;

/**
 * Here, we should have an agent that send events of time steps to the other agents
 */
@SarlSpecification("0.5")
@SuppressWarnings("all")
public class Time extends Agent {
  @SyntheticMember
  public Time(final UUID parentID, final UUID agentID) {
    super(parentID, agentID);
  }
  
  @SyntheticMember
  @Inject
  public Time(final BuiltinCapacitiesProvider provider, final UUID parentID, final UUID agentID) {
    super(provider, parentID, agentID);
  }
}

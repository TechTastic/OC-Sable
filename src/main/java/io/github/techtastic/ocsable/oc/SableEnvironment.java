package io.github.techtastic.ocsable.oc;

import dev.ryanhcode.sable.Sable;
import dev.ryanhcode.sable.companion.SableCompanion;
import dev.ryanhcode.sable.physics.config.dimension_physics.DimensionPhysicsData;
import dev.ryanhcode.sable.sublevel.ServerSubLevel;
import dev.ryanhcode.sable.sublevel.SubLevel;
import li.cil.oc.api.Network;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Callback;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.EnvironmentHost;
import li.cil.oc.api.network.Visibility;
import li.cil.oc.api.prefab.AbstractManagedEnvironment;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

public class SableEnvironment extends AbstractManagedEnvironment {
    private final EnvironmentHost host;

    public SableEnvironment(EnvironmentHost host) {
        this.host = host;
        setNode(Network.newNode(this, Visibility.Network).withComponent("sable").create());
    }

    @NotNull
    private Vec3 getPosition() {
        return new Vec3(this.host.xPosition(), this.host.yPosition(), this.host.zPosition());
    }

    @Nullable
    private ServerSubLevel getSublevel() {
        SubLevel access = Sable.HELPER.getContaining(this.host.getEnvironmentLevel(), this.getPosition());
        if (!(access instanceof ServerSubLevel sublevel)) return null;
        return sublevel;
    }

    @Callback
    public Object[] isInPlotGrid(final Context context, final Arguments args) {
        return new Object[] {Sable.HELPER.isInPlotGrid(this.host.getEnvironmentLevel(), this.getPosition())};
    }

    @Callback(getter = true)
    public Object[] uniqueId(final Context context, final Arguments args) {
        ServerSubLevel sublevel = this.getSublevel();
        return new Object[] {sublevel == null ? null : sublevel.getUniqueId().toString()};
    }

    @Callback(getter = true, setter = true)
    public Object[] name(final Context context, final Arguments args) {
        ServerSubLevel sublevel = this.getSublevel();
        if (args.isString(0) && sublevel != null)
            sublevel.setName(args.checkString(0));
        else
            return new Object[] {sublevel == null ? null : sublevel.getName()};
        return new Object[0];
    }

    @Callback(getter = true)
    public Object[] logicalPose(final Context context, final Arguments args) {
        ServerSubLevel sublevel = this.getSublevel();
        return new Object[] {sublevel == null ? null : sublevel.logicalPose()};
    }

    @Callback(getter = true)
    public Object[] lastPose(final Context context, final Arguments args) {
        ServerSubLevel sublevel = this.getSublevel();
        return new Object[] {sublevel == null ? null : sublevel.lastPose()};
    }

    @Callback(getter = true)
    public Object[] velocity(final Context context, final Arguments args) {
        return new Object[] {SableCompanion.INSTANCE.getVelocity(this.host.getEnvironmentLevel(), this.getPosition().toVector3f().get(new Vector3d()))};
    }

    @Callback(getter = true)
    public Object[] linearVelocity(final Context context, final Arguments args) {
        ServerSubLevel sublevel = this.getSublevel();
        return new Object[] {sublevel == null ? null : sublevel.latestLinearVelocity};
    }

    @Callback(getter = true)
    public Object[] angularVelocity(final Context context, final Arguments args) {
        ServerSubLevel sublevel = this.getSublevel();
        return new Object[] {sublevel == null ? null : sublevel.latestAngularVelocity};
    }

    @Callback(getter = true)
    public Object[] centerOfMass(final Context context, final Arguments args) {
        ServerSubLevel sublevel = this.getSublevel();
        return new Object[] {sublevel == null ? null : sublevel.getMassTracker().getCenterOfMass()};
    }

    @Callback(getter = true)
    public Object[] mass(final Context context, final Arguments args) {
        ServerSubLevel sublevel = this.getSublevel();
        return new Object[] {sublevel == null ? null : sublevel.getMassTracker().getMass()};
    }

    @Callback(getter = true)
    public Object[] inverseMass(final Context context, final Arguments args) {
        ServerSubLevel sublevel = this.getSublevel();
        return new Object[] {sublevel == null ? null : sublevel.getMassTracker().getInverseMass()};
    }

    @Callback(getter = true)
    public Object[] inertiaTensor(final Context context, final Arguments args) {
        ServerSubLevel sublevel = this.getSublevel();
        return new Object[] {sublevel == null ? null : sublevel.getMassTracker().getInertiaTensor()};
    }

    @Callback(getter = true)
    public Object[] inverseInertiaTensor(final Context context, final Arguments args) {
        ServerSubLevel sublevel = this.getSublevel();
        return new Object[] {sublevel == null ? null : sublevel.getMassTracker().getInverseInertiaTensor()};
    }

    @Callback
    public Object[] getAirPressure(final Context context, final Arguments args) {
        return new Object[] {DimensionPhysicsData.getAirPressure(this.host.getEnvironmentLevel(), new Vector3d(args.checkDouble(0), args.checkDouble(1), args.checkDouble(2)))};
    }

    @Callback(getter = true)
    public Object[] gravity(final Context context, final Arguments args) {
        return new Object[] {DimensionPhysicsData.getGravity(this.host.getEnvironmentLevel(), new Vector3d(args.checkDouble(0), args.checkDouble(1), args.checkDouble(2)))};
    }

    @Callback(getter = true)
    public Object[] magneticNorth(final Context context, final Arguments args) {
        return new Object[] {DimensionPhysicsData.getMagneticNorth(this.host.getEnvironmentLevel())};
    }

    @Callback(getter = true)
    public Object[] universalDrag(final Context context, final Arguments args) {
        return new Object[] {DimensionPhysicsData.getUniversalDrag((ServerLevel) this.host.getEnvironmentLevel())};
    }

    @Callback(getter = true)
    public Object[] dimensionPhysics(final Context context, final Arguments args) {
        return new Object[] {DimensionPhysicsData.of(this.host.getEnvironmentLevel())};
    }

    @Callback(getter = true)
    public Object[] defaultDimensionPhysics(final Context context, final Arguments args) {
        return new Object[] {DimensionPhysicsData.getDefault(this.host.getEnvironmentLevel())};
    }
}

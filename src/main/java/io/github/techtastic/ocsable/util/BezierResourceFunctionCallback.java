package io.github.techtastic.ocsable.util;

import dev.ryanhcode.sable.physics.config.dimension_physics.BezierResourceFunction;
import li.cil.oc.api.machine.Arguments;
import li.cil.oc.api.machine.Context;
import li.cil.oc.api.network.ManagedPeripheral;
import li.cil.oc.api.prefab.AbstractValue;

public class BezierResourceFunctionCallback extends AbstractValue implements ManagedPeripheral {
    private static final String[] METHODS = { "getPoints", "evaluateFunction" };

    private final BezierResourceFunction function;

    public BezierResourceFunctionCallback(BezierResourceFunction function) {
        this.function = function;
    }

    @Override
    public String[] methods() {
        return METHODS;
    }

    @Override
    public Object[] invoke(String method, Context context, Arguments args) throws Exception {
        return switch (method) {
            case "getPoints" -> new Object[] {this.function.getPoints()};
            case "evaluateFunction" -> new Object[] {this.function.evaluateFunction(args.checkDouble(0))};
            default -> throw new NoSuchMethodException(method);
        };
    }
}

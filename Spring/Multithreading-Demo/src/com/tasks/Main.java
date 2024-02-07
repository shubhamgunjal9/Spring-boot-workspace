package com.tasks;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.optim.linear.LinearObjectiveFunction;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.linear.LinearConstraint;
import org.apache.commons.math3.optim.linear.LinearConstraintSet;
import org.apache.commons.math3.optim.linear.NonNegativeConstraint;
import org.apache.commons.math3.optim.MaxIter;
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.SimplexSolver;


public class Main {

    public static void main(String[] args) {
        double[] pnl = {1.1, 0.9, 2.2, 0.7, 1.6};
        double[][] bounds = {{0, 19}, {0, 19}, {0, 19}, {0, 19}, {0, 19}};
        double[][] coefficients = {{-25, 1, 1, 0, 0},
                                    {25, -1, 0, -1, 0},
                                    {25, 0, -1, 0, -1}};
        Relationship[] relationships = {Relationship.GEQ, Relationship.LEQ, Relationship.LEQ};
        double[] rhs = {0.5, -0.5, -0.5};

        int nRows = relationships.length;
        int nCols = pnl.length;
        LinearConstraint[] constraints = new LinearConstraint[nRows];
        for (int i = 0; i < nRows; i++) {
            double[] coeffs = new double[nCols];
            for (int j = 0; j < nCols; j++) {
                coeffs[j] = coefficients[i][j];
            }
            constraints[i] = new LinearConstraint(coeffs, relationships[i], rhs[i]);
        }

        OptimizationData[] optData = {new LinearObjectiveFunction(pnl, 0),
                                      new LinearConstraintSet(constraints),
                                      new NonNegativeConstraint(true),
                                      new MaxIter(1000)};
        SimplexSolver solver = new SimplexSolver();
        PointValuePair solution = solver.optimize(optData);
        double[] variableValues = solution.getPoint();
        double objValue = solution.getValue();

        System.out.println("PnL total: " + String.format("%.2f", objValue));
        int nAssigned = 0;
        for (int i = 0; i < nRows; i++) {
            double assignValue = variableValues[i];
            if (assignValue > 0.5) {
                nAssigned++;
            }
        }
        System.out.println("Assigned rows: " + nAssigned + "/" + nRows);
        System.out.println("Bounds:");
        Map<String, double[]> boundsMap = new HashMap<>();
        for (int j = 0; j < nCols; j++) {
            String vName = "v_" + j;
            boundsMap.put(vName, new double[] {bounds[j][0], bounds[j][1]});
        }
        for (String vName : boundsMap.keySet()) {
            double[] vBounds = boundsMap.get(vName);
            System.out.println(vName + ": [" + String.format("%.2f", vBounds[0]) + ", " + String.format("%.2f", vBounds[1]) + "]");
        }
    }
}
=
package ast;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Sample user data
        Map<String, Integer> userDataMap = new HashMap<>();
        userDataMap.put("age", 35);
        userDataMap.put("salary", 60000);
        userDataMap.put("experience", 6);

        UserData userData = new UserData(userDataMap);

        // Create conditions
        Condition ageCondition = new NumericCondition("age", ">", 30);
        Condition salaryCondition = new NumericCondition("salary", ">", 50000);
        Condition experienceCondition = new NumericCondition("experience", ">", 5);

        // Create nodes for the conditions
        Node ageNode = new OperandNode(ageCondition);
        Node salaryNode = new OperandNode(salaryCondition);
        Node experienceNode = new OperandNode(experienceCondition);

        // Combine conditions into an AST
        Node rule1 = new OperatorNode("AND", ageNode, salaryNode);
        Node rule2 = new OperatorNode("AND", rule1, experienceNode);

        // Evaluate the rule
        boolean result = rule2.evaluate(userData);
        System.out.println("Is user eligible? " + result);
    }
}

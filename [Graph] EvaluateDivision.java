/*
399. Evaluate Division
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

link: leetcode.com/problems/evaluate-division
*/


class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> graph = buildGraph(equations, values);

        return dfs(graph,queries);
    }

    private double[] dfs(Map<String,Map<String,Double>> graph, List<List<String>> queries){
        double[] ans = new double[queries.size()];

        for(int i=0; i<queries.size(); i++){
            List<String> list = queries.get(i);
            String origin = list.get(1), destination = list.get(0);
            ans[i] = dfs(origin,destination,graph,new HashSet<>());
        }

        return ans;
    }

    private double dfs(String origin, String destination, Map<String,Map<String,Double>> graph, Set<String> visited){
        visited.add(origin);

        if(!graph.containsKey(origin))
            return -1.0;

        if (graph.get(origin).containsKey(destination))
            return graph.get(origin).get(destination);

        for(Map.Entry<String, Double> nbr : graph.get(origin).entrySet()){
            if(!visited.contains(nbr.getKey())){
                double weight = dfs(nbr.getKey(), destination, graph, visited);
                
                if(weight != -1.0){
                    return nbr.getValue() * weight;
                }
            }
        }

        return -1.0;
    }

    private Map<String,Map<String,Double>> buildGraph(List<List<String>> equations, double[] values){
        Map<String,Map<String,Double>> graph = new HashMap<>();
        int n = values.length;

        for(int i=0; i<n; i++){
            Map<String,Double> list0 = graph.getOrDefault(equations.get(i).get(0), new HashMap<>());
            Map<String,Double> list1 = graph.getOrDefault(equations.get(i).get(1), new HashMap<>());
            if(list0.size()==0)
                list0.put(equations.get(i).get(0),1.0);
            if(list1.size()==0)
                list1.put(equations.get(i).get(1),1.0);

            list1.put(equations.get(i).get(0),values[i]);
            list0.put(equations.get(i).get(1),1/values[i]);
            
            graph.put(equations.get(i).get(0),list0);
            graph.put(equations.get(i).get(1),list1);
        }

        return graph;
    }
}

package com.yl.learn.algorithm.kuaishou;

import java.util.Arrays;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 来源：力扣（LeetCode）207
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MapCanFinish {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses];
        build(graph, prerequisites);
        // 判断是否有环
        for(int i = 0; i < graph.length; i++) {
            if(!dfs(graph, i, new boolean[numCourses]))  return false;
        }
        return true;
    }

    private boolean dfs(int[][] graph, int course, boolean[] viewed) {
        if(viewed[course]) {
            return false;
        }
        for(int i = 0; i < graph[course].length; i++) {
            if(graph[course][i] == 1) {
                boolean[] copied = Arrays.copyOf(viewed, viewed.length);
                copied[course] = true;
                if(!dfs(graph, i, copied)) return false;
                graph[course][i] = -1;
            }
        }
        return true;
    }

    private void build(int[][] graph, int[][] prerequisites) {
        for(int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]][prerequisites[i][0]] = 1;
        }
    }

}

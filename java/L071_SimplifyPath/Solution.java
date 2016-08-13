package L071_SimplifyPath;

import java.util.LinkedList;

/**
 * @author: deadend
 * @date: 2:25 PM 8/12/16
 * @version: 1.0
 * @description: Leetcode 71. Simplify Path
 */


public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();

        String[] slugs = path.split("/");
        for (int i = slugs.length - 1; i >= 0; i--) {
            if (slugs[i].equals("") || slugs[i].equals("."))
                continue;

            if (!slugs[i].equals("..") && !stack.isEmpty() && stack.peek().equals("..")) {
                stack.pop();
            } else {
                stack.push(slugs[i]);
            }
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            String slug = stack.pop();
            if (!slug.equals(".."))
                sb.append("/" + slug);
        }
        return sb.length() == 0 ? "/" : path.startsWith("/") ? sb.toString() : sb.substring(1);
    }

    public static void main(String[] args) {
        String path = "/...";
        System.out.println(new Solution().simplifyPath(path));
    }
}

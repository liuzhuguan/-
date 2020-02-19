import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/*
    并查集结构
 */
public class UnionFind {

    public static class Node {
        private Node left;
        private Node right;
        private int value;
    }


    public static class UnionFindSet {
        private HashMap<Node,Node> fatherMap;  //一个点 和 他的上一个节点
        private HashMap<Node,Integer> sizeMap; // 点所在集合的大小

        public UnionFindSet() {
            this.fatherMap = new HashMap<>();
            this.sizeMap = new HashMap<>();
        }

        //初始状态 自连接
        public void makeSets(List<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                fatherMap.put(node,node);
                sizeMap.put(node,1);
            }
        }

        private Node findHead(Node node) {
            Node father = fatherMap.get(node);
            while (father != node) {
                father = findHead(father);
            }

            fatherMap.put(node,father);
            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return (findHead(a) == findHead(b));
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }

//            找到两个节点的头  对比查看
//            未优化
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                int aSize = sizeMap.get(a);
                int bSize = sizeMap.get(b);

                if (aSize >= bSize) {
                    fatherMap.put(b,a);
                    sizeMap.put(a,aSize + bSize);
                } else {
                    fatherMap.put(a,b);
                    sizeMap.put(b,aSize + bSize);
                }
            }
        }
    }

}

import java.util.HashMap;

/*
    【题目】 设计一种结构，在该结构中有如下三个功能：
    insert(key)：将某个key加入到该结构，做到不重复加入。
    delete(key)：将原本在结构中的某个key移除。
    getRandom()： 等概率随机返回结构中的任何一个key。
    【要求】 Insert、delete和getRandom方法的时间复杂度都是 O(1)
 */
public class RandomPool {

    //此处可传入任意类型
    public static class Pool<K> {
        private HashMap<K,Integer> map1 = new HashMap<>();
        private HashMap<Integer,K> map2 = new HashMap<>();
        private int size;

        public Pool() {
            this.map1 = new HashMap<>();
            this.map2 = new HashMap<>();
            this.size = 0;
        }

        public void insert(K key) {
            this.map1.put(key,size);
            this.map2.put(size,key);
            size++;
        }

        public K getRandom() {
            if (this.size == 0) {
                return null;
            }
            return this.map2.get((int)(Math.random() * size));
        }

        public void delete(K key) {
            if (this.map1.containsKey(key)) {
                int deleteIndex = this.map1.get(key);
                int lastIndex = --this.size;
                K key1 = this.map2.get(lastIndex);

                this.map1.put(key1,deleteIndex);
                this.map2.put(deleteIndex,key1);
                this.map1.remove(key);
                this.map2.remove(lastIndex);
            }
        }
    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<String>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");

        //System.out.println(pool.getRandom());
        System.out.println(pool.size);

        pool.delete("zuo");
        System.out.println(pool.size);
    }
}

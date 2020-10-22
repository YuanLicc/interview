import scala.collection._

object One {
    def twoSum(nums : Array[Int], target : Int) : Array[Int] = {
        if (nums.length <= 1) return Array(0, 0)
        val map = mutable.HashMap[Int, Int]()
        for(i <- nums.indices) {
            if(map.contains(nums(i)))  return Array(map(nums(i)), i)
            map.put(target - nums(i), i)
        }
        Array(0, 0)
    }
}

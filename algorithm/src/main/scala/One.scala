import scala.collection._

object One {
    def twoSum(nums : Array[Int], target : Int) : Array[Int] = {
        if (nums.length <= 1) return new Array[Int](2)
        val map = mutable.HashMap[Int, Int]()
        for(i <- 0 until nums.length) {
            val mapGet = map.get(nums(i))
            if(mapGet.isDefined)  return Array(mapGet.get, i)
            map.put(target - nums(i), i)
        }
        new Array[Int](2)
    }
}

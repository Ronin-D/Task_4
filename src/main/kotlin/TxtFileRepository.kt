
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter

private const val FILE_INPUT_NAME = "src/main/resources/input.txt"
private const val FILE_OUTPUT_NAME = "src/main/resources/output.txt"
class TxtFileRepository {

    fun concatenate():List<String>{
        BufferedReader(FileReader(FILE_INPUT_NAME)).use { input ->
            val l1 = input.readLine().split(",")
            val l2 = input.readLine().split(",")
            val l1l2 = mutableListOf<String>()
            for(s1 in l1){
                for (s2 in l2){
                    l1l2.add(
                        concatenateStrings(s1, s2)
                    )
                }
            }
            return l1l2
        }
    }

    fun writeConcatenate(l1l2:List<String>){
        BufferedWriter(FileWriter(FILE_OUTPUT_NAME)).use { output->
            output.write("L1L2 = {")
            for (s in l1l2){
                if (s!=l1l2.last())
                    output.write("$s,")
                else output.write("$s}")
            }
            output.flush()
        }
    }

    private fun concatenateStrings(s1:String, s2:String):String{
        return if(s1=="λ"&&s2==s1){
            "λ"
        } else if (s1=="λ"){
            s2
        } else if(s2=="λ"){
            s1
        } else{
            buildString {
                append(s1)
                append(s2)
            }
        }
    }
}
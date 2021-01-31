
package exam;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
        
public class EXAM {

    public static void main(String[] args) {
        Collection<File> listDocFiles = new ArrayList<File>();
        int counter = 0;
        long sTime = System.currentTimeMillis();
        addToList(new File("."), listDocFiles, counter);
        
        
        long eTime = System.currentTimeMillis();
        Iterator iter = listDocFiles.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
            counter++;
        }
        long time = (eTime - sTime) / 1000;
        System.out.println("The number of docx file is " + counter);
        System.out.println("The time needed for the search to be executed is " + time + " seconds");
    }
    
    public static void addToList(File f, Collection<File> listDocFiles, int counter){
        File[] files;
        if(counter == 0){
            files = File.listRoots();
            counter++;
        }else{
            files = f.listFiles();
        }
        if(files != null){
            for(File file : files){
                if(file.getName().endsWith(".docx")){
                    listDocFiles.add(file);
                }
                addToList(file, listDocFiles, counter);
            }
        }
    }
}

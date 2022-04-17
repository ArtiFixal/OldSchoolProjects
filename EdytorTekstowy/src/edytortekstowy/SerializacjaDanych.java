package edytortekstowy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

/**
 * Serialization and deserialization
 * 
 * @author ArtiFixal
 */
public class SerializacjaDanych {
    
    /**
     * Compresses and saves object to a file in specific directory.
     * 
     * @param o Object to be compressed and saved.
     * @param dir Path to which object will be saved.
     * @throws Exception Any error that occured.
     */
    public static void zapiszOb(Object o,String dir) throws Exception
    {
        try(FileOutputStream fos=new FileOutputStream(dir);ByteArrayOutputStream bos=new ByteArrayOutputStream();DeflaterOutputStream komp=new DeflaterOutputStream(bos);ObjectOutputStream out=new ObjectOutputStream(komp)){
                out.writeObject(o);
                out.close();
                byte[] buf=bos.toByteArray();
                fos.write(buf);
            }catch(Exception e){
                throw e;
            }
    }
    
    /**
     * Uncompresses and loads object from a file.
     * 
     * @param dir Path from object will be loaded.
     * @return Loaded object.
     * @throws Exception Any error that occured.
     */
    public static Object wczytajOb(String dir) throws Exception
    {
        Object o=null;
        try(FileInputStream in=new FileInputStream(dir);ByteArrayInputStream bi=new ByteArrayInputStream(in.readAllBytes());InflaterInputStream is=new InflaterInputStream(bi);ObjectInputStream oi=new ObjectInputStream(is)){
            o=oi.readObject();
        }catch(Exception e){
            throw e;
        }
        return o;
    }
}

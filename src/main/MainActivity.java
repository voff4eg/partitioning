/**
 * @author Vladimir Egorov
 *
 */

package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import partitioning.Partition;

public class MainActivity {
	/**
     * @param args
     */
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
                reader = new BufferedReader(new InputStreamReader(System.in));
                start();
        } catch (NumberFormatException e) {
                System.err.println("Неверный формат. Вводите валидные значения! " + e.getLocalizedMessage() );
                e.printStackTrace();
        } catch (IOException e) {
                System.err.println("Ошибка ввод/вывода! " + e.getLocalizedMessage() );
                e.printStackTrace();
        } catch (Exception e) {
                System.err.println("Неизвестная ошибка! " + e.getLocalizedMessage());
                e.printStackTrace();
        } finally {
            try {
                    reader.readLine();
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
        }
    }
    
    public static void start() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Количество разбиений на k слагаемых");            
        System.out.println("Введите количество точек: ");
        int n = Integer.valueOf(reader.readLine());
        System.out.println("Введите k: ");
        int k = Integer.valueOf(reader.readLine());
        
    	Partition P = new Partition(n,k);
    	System.out.println("Количество разбиений " + P.getPartitionCount());
    }
}

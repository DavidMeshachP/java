package reflection;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class DisplayingMethodAndClassNamesUsingReflection {
    public static void main(String args[]) throws Exception {

        Class<?>[] c = new Class<?>[2];
        c[0] = Class.forName("reflection.A");
        c[1] = Class.forName("reflection.B");

        for (int i = 0; i < c.length; i++) {

            Method[] methods = c[i].getDeclaredMethods();

            System.out.println(" Class Name : " + methods[0].getDeclaringClass());
            System.out.println();
            for (Method method : methods) {
                System.out.println(" Method Name : " + method);
            }

            System.out.println(
                    "-----------------------------------------------------------------------------------------");

        }

        System.out.println("Common methods inside the classes.............");
        System.out.println();
        Set<Method> uniqueMethods = new HashSet<Method>();
        for (int i = 0; i < c.length - 1; i++) {
            Method[] methodsA = c[i].getDeclaredMethods();
            for (Method method : methodsA) {
                for (int j = i + 1; j < c.length; j++) {
                    Method[] methodsB = c[j].getDeclaredMethods();
                    for(Method method2 : methodsB) {
                        if((method.getName()).equals(method2.getName()) && !(uniqueMethods.contains(method))) {
                            uniqueMethods.add(method);
                            System.out.println(" Method Name : " + method);
                        }
                    }
                }
            }
        }

    }
}
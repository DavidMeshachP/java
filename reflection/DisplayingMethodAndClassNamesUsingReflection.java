package reflection;

import java.lang.reflect.Method;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class DisplayingMethodAndClassNamesUsingReflection {
    public static void main(String args[]) throws Exception {

        Set<Class> s = new HashSet<Class>();
        s = findAllClassesUsingClassLoader("reflection");

        Iterator<Class> i = s.iterator();

        while ( i.hasNext() ) {
            Class x = i.next();
            if ( !(x.toString().startsWith("class")) ) {
                i.remove();
            }
        }

        // for ( Class x : s ) {
        //     if ( !(x.toString().startsWith("class")) ){
        //         s.remove(x);
        //     }
        // }

        for ( Class x : s ) {

            Method[] methods = x.getDeclaredMethods();

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
        for ( Class x : s ) {
            Method[] methodsA = x.getDeclaredMethods();
            for (Method method : methodsA) {
                Annotation[] annotations = method.getAnnotations();
                for ( Class y : s ) {
                    Method[] methodsB = y.getDeclaredMethods();
                    for (Method method2 : methodsB) {
                        if ((method.getName()).equals(method2.getName()) && !(uniqueMethods.contains(method))) {
                            if (checkParameters(method, method2)) {
                                System.out.println(" Method Name : " + method);
                                uniqueMethods.add(method);
                            }
                        }

                        if (annotations.length != 0) {
                            if(checkMethodAnnotations(method,method2)) {
                                if(checkParameterAnnotations(method, method2)) {
                                    System.out.println("parameter success...............");
                                }
                            }
                        }

                    }
                }
            }
        }

    }

    public static boolean checkParameters(Method method, Method method2) {

        if (Arrays.equals(method.getParameterTypes(), method2.getParameterTypes())) {
            return true;
        }

        return false;
    }

    public static boolean checkParameterAnnotations(Method method, Method method2) {
        Annotation[][] parameterAnnotations1 = method.getParameterAnnotations();
        Annotation[][] parameterAnnotations2 = method2.getParameterAnnotations();

        System.out.println("parameter annotations of method 1 ");

        if (parameterAnnotations1.length == parameterAnnotations2.length && parameterAnnotations1[0].length == parameterAnnotations2[0].length ) {
            for (int i = 0; i < parameterAnnotations1.length; i++) {
                for (int j = 0; j < parameterAnnotations1[i].length; ) {
                    if( parameterAnnotations1[i][j].annotationType().equals(parameterAnnotations2[i][j].annotationType())) {
                        System.out.println(parameterAnnotations1[i][j].annotationType());
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }
        }

        return false;
    }

    public static boolean checkMethodAnnotations(Method method, Method method2 ) {

        Annotation[] annotations1 = method.getAnnotations();
        Annotation[] annotations2 = method2.getAnnotations();

        if(Arrays.equals(annotations1,annotations2)) {
            System.out.println(annotations1[0].annotationType());
            return true;
        }

        return false;
    }

    //     Class<?>[] c = new Class<?>[2];
    //     c[0] = Class.forName("reflection.A");
    //     c[1] = Class.forName("reflection.B");

    //     for (int i = 0; i < c.length; i++) {

    //         Method[] methods = c[i].getDeclaredMethods();

    //         System.out.println(" Class Name : " + methods[0].getDeclaringClass());
    //         System.out.println();
    //         for (Method method : methods) {
    //             System.out.println(" Method Name : " + method);
    //         }

    //         System.out.println(
    //                 "-----------------------------------------------------------------------------------------");

    //     }

    //     System.out.println("Common methods inside the classes.............");
    //     System.out.println();
    //     Set<Method> uniqueMethods = new HashSet<Method>();
    //     for (int i = 0; i < c.length - 1; i++) {
    //         Method[] methodsA = c[i].getDeclaredMethods();
    //         for (Method method : methodsA) {
    //             Annotation[] annotations = method.getAnnotations();
    //             for (int j = i + 1; j < c.length; j++) {
    //                 Method[] methodsB = c[j].getDeclaredMethods();
    //                 for (Method method2 : methodsB) {
    //                     if ((method.getName()).equals(method2.getName()) && !(uniqueMethods.contains(method))) {
    //                         if (checkParameters(method, method2)) {
    //                             System.out.println(" Method Name : " + method);
    //                             uniqueMethods.add(method);
    //                         }
    //                     }

    //                     if (annotations.length != 0) {
    //                         if(checkMethodAnnotations(method,method2)) {
    //                             if(checkParameterAnnotations(method, method2)) {
    //                                 System.out.println("parameter success...............");
    //                             }
    //                         }
    //                     }

    //                 }
    //             }
    //         }
    //     }

    // }

    // public static boolean checkParameters(Method method, Method method2) {

    //     if (Arrays.equals(method.getParameterTypes(), method2.getParameterTypes())) {
    //         return true;
    //     }

    //     return false;
    // }

    // public static boolean checkParameterAnnotations(Method method, Method method2) {
    //     Annotation[][] parameterAnnotations1 = method.getParameterAnnotations();
    //     Annotation[][] parameterAnnotations2 = method2.getParameterAnnotations();

    //     System.out.println("parameter annotations of method 1 ");

    //     if (parameterAnnotations1.length == parameterAnnotations2.length && parameterAnnotations1[0].length == parameterAnnotations2[0].length ) {
    //         for (int i = 0; i < parameterAnnotations1.length; i++) {
    //             for (int j = 0; j < parameterAnnotations1[i].length; ) {
    //                 if( parameterAnnotations1[i][j].annotationType().equals(parameterAnnotations2[i][j].annotationType())) {
    //                     System.out.println(parameterAnnotations1[i][j].annotationType());
    //                     return true;
    //                 }
    //                 else {
    //                     return false;
    //                 }
    //             }
    //         }
    //     }

    //     return false;
    // }

    // public static boolean checkMethodAnnotations(Method method, Method method2 ) {

    //     Annotation[] annotations1 = method.getAnnotations();
    //     Annotation[] annotations2 = method2.getAnnotations();

    //     if(Arrays.equals(annotations1,annotations2)) {
    //         System.out.println(annotations1[0].annotationType());
    //         return true;
    //     }

    //     return false;
    // }

    // }

    public static Set<Class> findAllClassesUsingClassLoader(String packageName) {
        InputStream stream = ClassLoader.getSystemClassLoader()
          .getResourceAsStream(packageName.replaceAll("[.]", "/"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        return reader.lines()
          .filter(line -> line.endsWith(".class"))
          .map(line -> getClass(line, packageName))
          .collect(Collectors.toSet());
    }
    
    private static Class getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
              + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            // handle the exception
            System.out.println(" class cannot be found " + e );
        }
        return null;
    }

}
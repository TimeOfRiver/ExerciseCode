package effectiveJava.chap2;

import effectiveJava.chap2.Person;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/5/20
 */
public class testPerson {
    public static void main(String[] args) {
        Person person = new Person.Builder("Neo","18366668888")
                .age(24).idNumber("123321765432111111").build();
        System.out.println(person.toString());
        
    }
}

package effectiveJava;

/**
 * build pattern:使用场景，构造器或者静态工厂中有多个参数时（特别是有可选参数时），首选Builder模式
 *
 * @author luoyalan
 * @date 2018/5/20
 */
public class Person {

    private final String name;
    private final int age;
    private final int sex;
    private final String idNumber;
    private final String phoneNumber;
    private final String address;

    public static class Builder implements effectiveJava.Builder<Person> {
        // 必要参数
        private final String name;
        private final String phoneNumber;
        // 可选参数
        private int age = 0;
        private int sex = 0;// 0-man 1=female
        private String idNumber = "";
        private String address = "China";

        public Builder(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder sex(int sex) {
            this.sex = sex;
            return this;
        }

        public Builder idNumber(String idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }


    }

    private Person(Builder builder) {
        name = builder.name;
        age = builder.age;
        sex = builder.sex;
        phoneNumber = builder.phoneNumber;
        idNumber = builder.idNumber;
        address = builder.address;
    }
}

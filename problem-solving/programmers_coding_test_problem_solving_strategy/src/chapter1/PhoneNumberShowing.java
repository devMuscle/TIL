package chapter1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneNumberShowing {

    private static class PhoneNumber {
        public final String phoneNumber;

        public PhoneNumber(String rawPhoneNumber) {
            //정규표현식으로 숫자가 아닌 문자들을 제거
            this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]","");
        }

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof PhoneNumber)) return false;
            return phoneNumber.equals(((PhoneNumber) o).phoneNumber);
        }
    }

    private static class Person {
        public final String name;
        private final List<PhoneNumber> numbers;

        public Person(String name) {
            this.name = name;
            numbers = new ArrayList<>();
        }

        public void addPhoneNumber(PhoneNumber phoneNumber) {
            numbers.add(phoneNumber);
        }

        public boolean hasPhoneNumber(PhoneNumber number) {
            return numbers.contains(number);
        }

        @Override
        public String toString() {
            return "Person {" +
                    "name='" + name + '\'' +
                    ", numbers=" + numbers +
                    '}';
        }

        /* // numbers가 String인 경우 검사 로직 추가
        public boolean addPhoneNumber(String number) {
            for(char c : number.toCharArray()) {
                if(!Character.isDigit(c)) return false;
            }

            numbers.add(number);
            return true;
        }
         */
    }

    private static class PhoneBook {
        private final Set<Person> people;

        private PhoneBook() {
            people = new HashSet<>();
        }

        public void addPerson(Person person) {
            people.add(person);
        }

        public Person search(PhoneNumber number) {
            return people.stream()
                    .filter(p -> p.hasPhoneNumber(number))
                    .findFirst()
                    .orElse(null);
        }

        @Override
        public String toString() {
            return "PhoneBook{" +
                    "people=" + people +
                    '}';
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person("홍지표");
        person1.addPhoneNumber(new PhoneNumber("010-1234-5678"));
        person1.addPhoneNumber(new PhoneNumber("010-2345-6789"));

        Person person2 = new Person("김텔리");
        person2.addPhoneNumber(new PhoneNumber("010-2468-0246"));

        Person person3 = new Person("이자바");
        person3.addPhoneNumber(new PhoneNumber("010-1357-9135"));
        
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(person1);
        phoneBook.addPerson(person2);
        phoneBook.addPerson(person3);

        System.out.println(phoneBook.search(new PhoneNumber("01023456789")));
        System.out.println(phoneBook.search(new PhoneNumber("01024680246")));
        System.out.println(phoneBook.search(new PhoneNumber("01013579135")));
        System.out.println(phoneBook.search(new PhoneNumber("01000000000")));
    }
}

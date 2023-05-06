package org.example;

import org.example.repo.UserRepository;
import org.example.repo.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableCaching
public class QeydiDbAppJpaSpringApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(QeydiDbAppJpaSpringApplication.class, args);
    }
//implements CommandLineRunner
//    @Autowired
//    @Qualifier("userRepo")
//    private UserRepositoryCustom userRepositoryCustom;
@Autowired
private UserRepository userRepo;

@Autowired
@Qualifier("userRepoImpl")
private UserRepositoryCustom userrepo;
//
    @Override
    public void run(String... args) throws Exception {


//        System.out.println(userrepo.getUsersBySubject("zi").listIterator());
//        System.out.println(userRepo.findByTeachway_Teachway("Magistratura"));


//        User u = new User(22,"Elvin","Nasibov",27,"bdu",240,"donthave",2,5,"234567",240);
//        userServiceInter.updateUser(u);
//        User u=
//        System.out.println(userServiceInter.findByEmail("nem@gmail.com").getRole());
//        String[] authoritiesArr = new String[]{ "ADMIN", "USER", "ROLE_USER"};
////            String[] authoritiesArr = new String[]{user.getRole().toString()};
//        System.out.println("loazim olan asagidakidir");
//        System.out.println(authoritiesArr);
        ;
//        System.out.println(userServiceInter.getAll("Elvin","Nasibov","enasibov@gmail.com"));
//        System.out.println(userServiceInter.getAll("kadi","gadi","nem@gmail.com"));

        //        System.out.println(userServiceInter.findIdByEmailAndPassword("gadirovelsen@gmail.com","12345"));
    }
}

package Models;

import static org.junit.Assert.*;

import models.User;
import org.junit.Test;

import static play.test.Helpers.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by alejo on 11/18/2016.
 */
public class UserTest {

    public void testUserModel(){
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                String email = "test@test.com";
                String username= "testuser1";
                String pass= "testpass1";
                String passconf= "testpass1";


                User user =  new User();
                user.username = username;
                user.pass = username;
                user.passconf = passconf;


                user.save();

                User usersaved = user.find.byId(user.id);

                assertThat(usersaved , notNullValue());
                assertThat(usersaved.email, equalTo(email));
                assertThat(usersaved.username, equalTo(username));
                assertThat(usersaved.pass, equalTo(pass));
                assertThat(usersaved.passconf, equalTo(passconf));


            }
        });
    }


}

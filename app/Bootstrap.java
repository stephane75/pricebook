import models.User;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

/**
 * User: stephane
 * Date: 17/02/14
 */

@OnApplicationStart
public class Bootstrap extends Job {

    //Rempli la base avec un jeu de donnee pour la phase de test
    public void doJob() {
        // Check if the database is empty
        if(User.count() == 0) {
            Fixtures.loadModels("initial-data.yml");
        }
    }

}
package achievement;

import achievement.awards.BigWinnerAward;
import achievement.awards.BruiserAward;
import achievement.awards.SharpshooterAward;
import achievement.awards.VeteranAward;

import java.util.HashSet;

import static com.google.common.collect.Sets.newHashSet;

public class AchievementSetFactory {
    public HashSet<Achievement> createFullAchievementSet() {
        final HashSet<Achievement> achievements = newHashSet();
        achievements.add(new BigWinnerAward());
        achievements.add(new BruiserAward());
        achievements.add(new SharpshooterAward());
        achievements.add(new VeteranAward());

        return achievements;
    }
}

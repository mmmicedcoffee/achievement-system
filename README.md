achievement-system
==================

Achievement system coded up for a Riot Games interview challenge.



design overview
==================

There are three major components to this project: achievements, statistics, and a driver. 
With the first two, I had to focus on making sure my code was easily extensible, and with 
the latter, I had to think about API design and how a third-party might hook in my 
achievement system.  

I began by implementing a Player class, which I concluded would be comprised of a name, a 
set of lifetime statistics, a set of statistics from the last game played, a set of 
available achievements, and a set of achievements already earned.  From there, I needed to
design achievements and statistics.  

For achievements, since each achievement has its own 
logic for how to unlock it, I decided that I would make each achievement its own class 
that implemented a common Achievement interface.  Each achievement would handle evaluation
on its own if given a set of statistics.  

For statistics, I decided that since each statistic was only going to be comprised of an 
identifier and a value, I would simply create StatSet objects that contained a mapping of 
valid statistic identifiers to values.  I stored a list of statistic identifiers as enums 
in StatAttribute.  

With this in place, it follows that in my driver, a game consists of generating a 
game-specific StatSet for each player, using that information to update each player's 
lifetime StatSet, and then going through each player's list of available achievements that
have yet to be unlocked to see if any new ones were unlocked.



to run the driver
==================

Please excuse the un-aesthetic appearance of my driver output!  I did not spend very much 
time on formatting and such.

To run the driver, just run the Main class.  The NUM_GAMES constant can be changed to 
increase the number of games played.

The driver "plays" games by randomly generating game stats for the players on both teams 
and then checking at the end of each game to see if any achievements have been earned.



adding an award
==================

To add an achievement, create an implementation of the Achievement interface in the awards
package and fill in the evaluate method with the appropriate evaluation logic.



adding a statistic
==================

To add a statistic, add an identifier for the statistic in StatAttribute, and then, if 
you wish to also have the driver incorporate this statistic, go into the random stat 
generator in StatSetFactory and add appropriate logic that will generate a random number
for the new statistic.



my new achievement
==================

I added a statistic that counted the number of times a player recalled in one game, and
I added an achievement, called the Homesick Award, that will be awarded when a player
recalls more than 10 times in one game.



other comments
==================

I did not do a complete job of distinguishing lifetime statistics from game-specific 
statistics.  For example, wins and losses are really more of a lifetime statistic, so it
doesn't make that much sense for them to go into a game-specific set of statistics.
However, for the purposes of the immediate assignment to implement the statistics listed
in the handout, there was not a huge disparity between lifetime stats and game-specific
stats, and I felt it was easier to just turn in an implementation that clumped all stats
together.

If it turns out that game-specific stats differ wildly from lifetime stats, then I would
create an interface for StatSet and write two different implementations for it.  I would
also have to either implement helper methods in StatKey (the enum file containing the 
stat identifiers) to distinguish identifiers of lifetime stats from game-specific stats, 
or maintain two separate enums - I would have to further investigate this issue.
# com.wyre.JDaven
A Java Library that can get minyanim for pretty much anywhere in the World!

There are three ways to search for minyanim and each way is overloaded to allow you to specify the max amount of results to receive

Note: The max is twenty.
1-By shul Name. JDaven daven = new JDaven("Chabad Jewish Center");
2-By Latitude and Longitude. Note-They must be double values otherwise the compiler will choose the zipcode version of the constructor. Jdaven daven = new JDaven(72.143,42.436);
3-By ZipCode. JDaven daven = new JDaven(90001);

You can overload any of these with a integer that specifies the max amount of results.

Each minyan is encapsulated in a minyanim class which has all of the properties of the minyan and can be retreived by using the getInsertPropertyNameHere() for that property.

To get the array of minyanim just call the getMinyanim() function on the daven object. From their you can iterate through each minyan in the array retreiving the propertys that you would like.

This library has a dependency on the google gson library. Make sure you have it in your class path!
Credit goes to GoDaven.com as this library relies on their API


public class City implements Comparable<City> {
private String city;
private int population;

public City() 
{
	city = null;
	population= 0;
}
public City(String c, int p) 
{
	city = c;
	population = p;
}

 public String getCity()
 {
	 return city;
 }
 
 public int getPopulation()
 {
	 return population;
 }
 
 public void setCity(String c)
 {
	city=c;
 }
 
 public void setPopulation(int p)
 {
	population = p;
 }
@Override
public int compareTo(City that) {
	// TODO Auto-generated method stub
	return this.population - that.population;
}

}

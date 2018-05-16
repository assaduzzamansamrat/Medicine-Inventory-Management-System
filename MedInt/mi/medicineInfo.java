package mi;

public class medicineInfo 
{
    private String ID;
    private String Name;
    private String Quantity;
	private String Price;
	
    public String getID() 
	{
        return ID;
    }

    public String getName() 
	{
        return Name;
    }

    public String getQuantity() 
	{
        return Quantity;
    }
	
	public String getPrice() 
	{
        return Price;
    }

    public void setID(String ID) 
	{
        this.ID = ID;
    }

    public void setName(String Name) 
	{
        this.Name = Name;
    }

    public void setPrice(String Price)
	{
		this.Price = Price;
	}
	
	public void setQuantity(String Quantity)
	{
		this.Quantity = Quantity;
	}
	
	public String toString(){
		return this.Name;
	}
}

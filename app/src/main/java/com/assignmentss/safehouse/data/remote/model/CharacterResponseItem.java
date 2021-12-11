package com.assignmentss.safehouse.data.remote.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CharacterResponseItem implements Parcelable {

	@SerializedName("birthday")
	private String birthday;

	@SerializedName("img")
	private String img;

	@SerializedName("better_call_saul_appearance")
	private List<Object> betterCallSaulAppearance;

	@SerializedName("occupation")
	private List<String> occupation;

	@SerializedName("appearance")
	private List<Integer> appearance;

	@SerializedName("portrayed")
	private String portrayed;

	@SerializedName("name")
	private String name;

	@SerializedName("nickname")
	private String nickname;

	@SerializedName("char_id")
	private int charId;

	@SerializedName("category")
	private String category;

	@SerializedName("status")
	private String status;

	public CharacterResponseItem() {
	}



	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

	public String getBirthday(){
		return birthday;
	}

	public void setImg(String img){
		this.img = img;
	}

	public String getImg(){
		return img;
	}

	public void setBetterCallSaulAppearance(List<Object> betterCallSaulAppearance){
		this.betterCallSaulAppearance = betterCallSaulAppearance;
	}

	public List<Object> getBetterCallSaulAppearance(){
		return betterCallSaulAppearance;
	}

	public void setOccupation(List<String> occupation){
		this.occupation = occupation;
	}

	public List<String> getOccupation(){
		return occupation;
	}

	public void setAppearance(List<Integer> appearance){
		this.appearance = appearance;
	}

	public List<Integer> getAppearance(){
		return appearance;
	}

	public void setPortrayed(String portrayed){
		this.portrayed = portrayed;
	}

	public String getPortrayed(){
		return portrayed;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setNickname(String nickname){
		this.nickname = nickname;
	}

	public String getNickname(){
		return nickname;
	}

	public void setCharId(int charId){
		this.charId = charId;
	}

	public int getCharId(){
		return charId;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseItem{" + 
			"birthday = '" + birthday + '\'' + 
			",img = '" + img + '\'' + 
			",better_call_saul_appearance = '" + betterCallSaulAppearance + '\'' + 
			",occupation = '" + occupation + '\'' + 
			",appearance = '" + appearance + '\'' + 
			",portrayed = '" + portrayed + '\'' + 
			",name = '" + name + '\'' + 
			",nickname = '" + nickname + '\'' + 
			",char_id = '" + charId + '\'' + 
			",category = '" + category + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

	public String getNameOccupation() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append(name);
		stringBuilder.append(" : ");
		List<String> occupations = getOccupation();
		for (String occupation:occupations ){
			stringBuilder.append(occupation);
		}
		return stringBuilder.toString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.birthday);
		dest.writeString(this.img);
		dest.writeList(this.betterCallSaulAppearance);
		dest.writeStringList(this.occupation);
		dest.writeList(this.appearance);
		dest.writeString(this.portrayed);
		dest.writeString(this.name);
		dest.writeString(this.nickname);
		dest.writeInt(this.charId);
		dest.writeString(this.category);
		dest.writeString(this.status);
	}

	public void readFromParcel(Parcel source) {
		this.birthday = source.readString();
		this.img = source.readString();
		this.betterCallSaulAppearance = new ArrayList<>();
		source.readList(this.betterCallSaulAppearance, Object.class.getClassLoader());
		this.occupation = source.createStringArrayList();
		this.appearance = new ArrayList<>();
		source.readList(this.appearance, Integer.class.getClassLoader());
		this.portrayed = source.readString();
		this.name = source.readString();
		this.nickname = source.readString();
		this.charId = source.readInt();
		this.category = source.readString();
		this.status = source.readString();
	}

	protected CharacterResponseItem(Parcel in) {
		this.birthday = in.readString();
		this.img = in.readString();
		this.betterCallSaulAppearance = new ArrayList<>();
		in.readList(this.betterCallSaulAppearance, Object.class.getClassLoader());
		this.occupation = in.createStringArrayList();
		this.appearance = new ArrayList<>();
		in.readList(this.appearance, Integer.class.getClassLoader());
		this.portrayed = in.readString();
		this.name = in.readString();
		this.nickname = in.readString();
		this.charId = in.readInt();
		this.category = in.readString();
		this.status = in.readString();
	}

	public static final Parcelable.Creator<CharacterResponseItem> CREATOR = new Parcelable.Creator<CharacterResponseItem>() {
		@Override
		public CharacterResponseItem createFromParcel(Parcel source) {
			return new CharacterResponseItem(source);
		}

		@Override
		public CharacterResponseItem[] newArray(int size) {
			return new CharacterResponseItem[size];
		}
	};
}
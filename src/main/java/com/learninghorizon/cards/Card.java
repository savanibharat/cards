package com.learninghorizon.cards;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import com.learninghorizon.misc.JSONUtils;
import com.learninghorizon.misc.Validate;

/**
 * Card studied or not. default false
 * 
 * Two cards are equals when cardQuestion, cardAnswer
 * are same.<br/>
 * */
public final class Card {

	private String cardQuestion;
	private String cardAnswer;
	
	/**
	 * publicationTime is
	 * <li> {@link System#currentTimeMillis()} </li>
	 * */
	private Long publicationTime;

	public Card(final String cardQuestion, 
				final String cardAnswer) {
		
		super();
		validate(cardQuestion, cardAnswer);
	}
	
	/**
	 * Helps constructor set newly created object to its 
	 * initial, stable, safe state.
	 * */
	private void validate(final String cardQuestion, 
						  final String cardAnswer){
		
		if (Validate.validateNullAndEmpty(cardQuestion) && 
				Validate.validateNullAndEmpty(cardAnswer)) {
			this.cardQuestion = cardQuestion;
			this.cardAnswer = cardAnswer;
			this.publicationTime = Long.valueOf(System.currentTimeMillis());
		}
		else{
			throw new InValidCardDetails(
				"Card questions and answer must not be null or empty."
			);
		}
	}
	
	/**
	 * @return 
	 * cardQuestion <br/>
	 * cardQuestion will never be null or empty.
	 * */
	public String cardQuestion() {
		return this.cardQuestion;
	}

	/**
	 * @return cardAnswer <br/>
	 * cardAnswer will never be null or empty.
	 * */
	public String cardAnswer() {
		return this.cardAnswer;
	}
	
	/**
	 * @return publicationTime
	 * publicationTime will be current time.
	 * */
	public Long publicationTime() {
		return this.publicationTime;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardAnswer == null) ? 0 : cardAnswer.hashCode());
		result = prime * result + ((cardQuestion == null) ? 0 : cardQuestion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardAnswer == null) {
			if (other.cardAnswer != null)
				return false;
		} else if (!cardAnswer.equals(other.cardAnswer))
			return false;
		if (cardQuestion == null) {
			if (other.cardQuestion != null)
				return false;
		} else if (!cardQuestion.equals(other.cardQuestion))
			return false;
		return true;
	}

	@Override
	public String toString() {

		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("cardQuestion", this.cardQuestion());
		map.put("cardAnswer", this.cardAnswer());
		map.put("publicationTime", this.publicationTime());

		return JSONUtils.convertMapToString(Collections.unmodifiableMap(map));
	}
}

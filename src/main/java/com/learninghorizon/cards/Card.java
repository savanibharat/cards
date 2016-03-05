package com.learninghorizon.cards;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import com.learninghorizon.misc.JSONUtils;
import com.learninghorizon.misc.Validate;
import com.learninghorizon.user.Identifier;

/**
 * Card studied or not. default false
 * 
 * Should card have an id? <br/>
 * 
 * Two cards are equals when cardQuestion, cardAnswer and publicationTime
 * are same.<br/>
 * Shall we just keep cardQuestion and cardAnswer as equals and hashCode
 * attributes?
 * 
 * */
public final class Card implements Identifier {

	private String cardQuestion;
	private String cardAnswer;
	private final String identifier = UUID.randomUUID().toString();
	/**
	 * publicationTime is
	 * <li> {@link System#currentTimeMillis()} </li>
	 * */
	private long publicationTime;
	
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
		
		Validate.validateNullAndEmpty(
				cardQuestion, 
				"Card Question must not be null or empty"
		);
		Validate.validateNullAndEmpty(
				cardAnswer, 
				"Card Answer must not be null or empty"
		);

		this.cardQuestion = cardQuestion;
		this.cardAnswer = cardAnswer;
		this.publicationTime = System.currentTimeMillis();
	}
	
	@Override
	public String uniqueIdentifier() {
		return this.identifier;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardAnswer == null) ? 0 : cardAnswer.hashCode());
		result = prime * result + ((cardQuestion == null) ? 0 : cardQuestion.hashCode());
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + (int) (publicationTime ^ (publicationTime >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (publicationTime != other.publicationTime)
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

package com.halukkilincer.adventure.utils;

import com.halukkilincer.adventure.characters.AbstractCharacter;

public abstract class NormalLoc extends Location {

	public NormalLoc(AbstractCharacter player, String name, String locationEmoji) {
		super(player, name, locationEmoji);
	}

	@Override
	public boolean getLocation() {
		return true;
	}

}

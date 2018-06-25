package com.yan.group;

import javax.validation.GroupSequence;

public interface UserGroup {
	public interface LoginFirstGroup {
	}

	public interface LoginSecondGroup {
	}

	@GroupSequence({ LoginFirstGroup.class, LoginSecondGroup.class })
	public interface LoginGroup {
	}
}

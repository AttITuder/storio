package com.pushtorefresh.storio.common.annotations.processor.introspection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.reflect.Whitebox.getInternalState;

import java.lang.annotation.Annotation;

import org.junit.Before;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

public class StorIOTypeMetaTest {
	
	private Annotation annotationMock;
	
	@Before
	public void setUp() throws Exception {
		annotationMock = mock(Annotation.class);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public final void constructor() {
		// when
		StorIOTypeMeta storioTypeMeta = new StorIOTypeMeta("TEST", "TEST", annotationMock);
		
		// then
		assertThat("TEST").as("Constructor must be set simpleName field.").isEqualTo(getInternalState(storioTypeMeta, "simpleName"));
		assertThat("TEST").as("Constructor must be set packageName field.").isEqualTo(getInternalState(storioTypeMeta, "packageName"));
		assertThat(annotationMock).as("Constructor must be set storIOType field.").isEqualTo(getInternalState(storioTypeMeta, "storIOType"));
	}

	@Test
	public final void equalsAndHashCode() {
		EqualsVerifier.forClass(StorIOTypeMeta.class).suppress(Warning.REFERENCE_EQUALITY).usingGetClass().verify();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public final void toStringValitadion() {
		// given
		StorIOTypeMeta storioTypeMeta = new StorIOTypeMeta("TEST", "TEST", annotationMock);
		String expectedString = "StorIOTypeMeta{" +
                "simpleName='TEST" + '\'' +
                ", packageName='TEST" + '\'' +
                ", storIOType=" + annotationMock +
                ", columns=" + getInternalState(storioTypeMeta, "columns") +
                '}';
		
		// when
		String toString = storioTypeMeta.toString();

		// then
		assertThat(expectedString).as("toString method should be equal with expectedString.").isEqualTo(toString);
	}

}

package com.ilmtest.ocean.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ilmtest.searchengine.model.Entry;

public class EntryUtilsTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void intro1()
	{
		Entry e = new Entry("يَزِيدُ بْنُ هَارُونَ، أَنْبَأَنَا جَرِيرُ بْنُ حَازِمٍ، عَنْ قَتَادَةَ، عَنْ أَنَسٍ، قَالَ كَانَ شَعَرُ رَسُولِ اللَّهِ ـ صلى الله عليه وسلم ـ شَعَرًا رَجِلاً بَيْنَ أُذُنَيْهِ وَمَنْكِبَيْهِ.");
		Entry other = new Entry("حدثنا أبو بكر بن أبي شيبة حدثنا يزيد بن هارون أنبأنا جرير بن حازم عن قتادة عن أنس قال كان شعر رسول الله صلى الله عليه وسلم شعرا رجلا بين أذنيه ومنكبيه.");
		assertTrue( EntryUtils.isSame(e, other) );
		
		other = new Entry("حَدَّثَنَا أَبُو بَكْرِ بْنُ أَبِي شَيْبَةَ قَالَ: حَدَّثَنَا يَزِيدُ بْنُ هَارُونَ قَالَ: أَنْبَأَنَا جَرِيرُ بْنُ حَازِمٍ، عَنْ قَتَادَةَ، عَنْ أَنَسٍ قَالَ: «كَانَ شَعَرُ رَسُولِ اللَّهِ صَلَّى اللهُ عَلَيْهِ وَسَلَّمَ شَعَرًا رَجِلًا بَيْنَ أُذُنَيْهِ وَمَنْكِبَيْهِ»");
		assertTrue( EntryUtils.isSame(e, other) );
		
		other = new Entry("حدثنا محمد بن الصباح قال أنبأنا جرير عن الأعمش عن أبي صالح عن أبي هريرة قال قال رسول الله صلى الله عليه وسلم ذروني ما تركتكم فإنما هلك من كان قبلكم بسؤالهم واختلافهم على أنبيائهم فإذا أمرتكم بشيء فخذوا منه ما استطعتم وإذا نهيتكم عن شيء فانتهوا.");
		assertFalse( EntryUtils.isSame(e, other) );
	}
}

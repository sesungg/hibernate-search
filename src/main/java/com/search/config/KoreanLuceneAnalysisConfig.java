package com.search.config;

import org.apache.lucene.analysis.ko.KoreanFilterFactory;
import org.apache.lucene.analysis.ko.KoreanTokenizerFactory;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;

public class KoreanLuceneAnalysisConfig  implements LuceneAnalysisConfigurer {
    @Override
    public void configure(LuceneAnalysisConfigurationContext context) {
        context.analyzer( "english" ).custom()
                .tokenizer( "standard" )
                .tokenFilter( "lowercase" )
                .tokenFilter( "snowballPorter" )
                .param( "language", "English" )
                .tokenFilter( "asciiFolding" );

        context.analyzer("koreanAnalyzer").custom()
                .tokenizer(KoreanTokenizerFactory.class)
//                .tokenFilter(KoreanPartOfSpeechStopFilterFactory.class)
//                .tokenFilter(KoreanReadingFormFilterFactory.class)
                .tokenFilter(KoreanFilterFactory.class);

    }
}
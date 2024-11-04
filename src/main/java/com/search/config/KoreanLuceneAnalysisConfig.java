package com.search.config;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.ko.KoreanFilterFactory;
import org.apache.lucene.analysis.ko.KoreanTokenizerFactory;
import org.apache.lucene.analysis.miscellaneous.ASCIIFoldingFilterFactory;
import org.apache.lucene.analysis.snowball.SnowballPorterFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurationContext;
import org.hibernate.search.backend.lucene.analysis.LuceneAnalysisConfigurer;

public class KoreanLuceneAnalysisConfig  implements LuceneAnalysisConfigurer {
    @Override
    public void configure(LuceneAnalysisConfigurationContext context) {
        context.analyzer( "english" ).custom()
                .tokenizer( StandardTokenizerFactory.class)
                .tokenFilter( LowerCaseFilterFactory.class)
                .tokenFilter( SnowballPorterFilterFactory.class)
                .param( "language", "English" )
                .tokenFilter( ASCIIFoldingFilterFactory.class);

        context.analyzer("koreanAnalyzer").custom()
                .tokenizer(KoreanTokenizerFactory.class)
                .tokenFilter(KoreanFilterFactory.class);

    }
}
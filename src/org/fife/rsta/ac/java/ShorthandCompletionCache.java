/*
 * 07/22/2012
 *
 * Copyright (C) 2012 Robert Futrell
 * robert_futrell at users.sourceforge.net
 * http://fifesoft.com/rsyntaxtextarea
 *
 * This library is distributed under a modified BSD license.  See the included
 * RSTALanguageSupport.License.txt file for details.
 */
package org.fife.rsta.ac.java;

import java.util.ArrayList;
import java.util.List;

import org.fife.rsta.ac.js.JavaScriptShorthandCompletionCache;
import org.fife.ui.autocomplete.Completion;
import org.fife.ui.autocomplete.DefaultCompletionProvider;


/**
 * A cache to store completions for Template completions and Comment
 * completions.  Template completions should extend
 * <code>TemplateCompletion</code> that uses parameterized variables/values.<p> 
 * 
 * While template completion example:
 * <pre>
 * while --&gt; while(condition) {
 *              //cursor here
 *           }
 * </pre>
 * 
 * Comment completion example:
 * <pre>
 * null --&gt; &lt;code&gt;null&lt;/code&gt;
 * </pre> 
 * 
 * This is really a convenient place to store these types of completions that
 * are re-used.
 * 
 * @see JavaShorthandCompletionCache
 * @see JavaScriptShorthandCompletionCache
 * @author Steve
 */
public abstract class ShorthandCompletionCache {

	
	private ArrayList shorthandCompletion = new ArrayList();
	private ArrayList commentCompletion = new ArrayList();
	
	private DefaultCompletionProvider templateProvider, commentProvider;
	
	public ShorthandCompletionCache(DefaultCompletionProvider templateProvider,
			DefaultCompletionProvider commentProvider) {
		this.templateProvider = templateProvider;
		this.commentProvider = commentProvider;
	}
	
	public void addShorthandCompletion(Completion completion) {
		shorthandCompletion.add(completion);
	}

	public List getShorthandCompletions() {
		return shorthandCompletion;
	}
	
	public void removeShorthandCompletion(Completion completion) {
		shorthandCompletion.remove(completion);
	}
	
	public void clearCache() {
		shorthandCompletion.clear();
	}
	
	//comments
	public void addCommentCompletion(Completion completion) {
		commentCompletion.add(completion);
	}

	public List getCommentCompletions() {
		return commentCompletion;
	}
	
	public void removeCommentCompletion(Completion completion) {
		commentCompletion.remove(completion);
	}
	
	public DefaultCompletionProvider getTemplateProvider() {
		return templateProvider;
	}
	
	public DefaultCompletionProvider getCommentProvider() {
		return commentProvider;
	}

}
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.wicket.jquery.ui.kendo.dropdown;

import java.util.List;

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

import com.googlecode.wicket.jquery.core.IJQueryWidget;
import com.googlecode.wicket.jquery.core.JQueryBehavior;
import com.googlecode.wicket.jquery.ui.kendo.KendoAbstractBehavior;

/**
 * Provides a Kendo UI DropDownList widget. It extends built-in {@link DropDownChoice}<br/>
 *
 * @author Sebastien Briquet - sebfz1
 *
 * @param <T> the model object type
 */
public class DropDownList<T> extends DropDownChoice<T> implements IJQueryWidget
{
	private static final long serialVersionUID = 1L;
	protected static final String METHOD = "kendoDropDownList";

	/** inner list width. 0 means that it will not be handled */
	private int width = 0;

	/**
	 * Constructor
	 * @param id the markup id
	 */
	public DropDownList(String id)
	{
		super(id);
	}

	/**
	 * Constructor
	 * @param id the markup id
	 * @param choices the collection of choices in the dropdown
	 */
	public DropDownList(String id, List<? extends T> choices)
	{
		super(id, choices);
	}

	/**
	 * Constructor
	 * @param id the markup id
	 * @param choices the collection of choices in the dropdown
	 * @param renderer the rendering engine
	 */
	public DropDownList(String id, List<? extends T> choices, IChoiceRenderer<? super T> renderer)
	{
		super(id, choices, renderer);
	}

	/**
	 * Constructor
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param choices the collection of choices in the dropdown
	 */
	public DropDownList(String id, IModel<T> model, List<? extends T> choices)
	{
		super(id, model, choices);
	}

	/**
	 * Constructor
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param choices the collection of choices in the dropdown
	 * @param renderer the rendering engine
	 */
	public DropDownList(String id, IModel<T> model, List<? extends T> choices, IChoiceRenderer<? super T> renderer)
	{
		super(id, model, choices, renderer);
	}

	/**
	 * Constructor
	 * @param id the markup id
	 * @param choices the collection of choices in the dropdown
	 */
	public DropDownList(String id, IModel<? extends List<? extends T>> choices)
	{
		super(id, choices);
	}

	/**
	 * Constructor
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param choices the collection of choices in the dropdown
	 */
	public DropDownList(String id, IModel<T> model, IModel<? extends List<? extends T>> choices)
	{
		super(id, model, choices);
	}

	/**
	 * Constructor
	 * @param id the markup id
	 * @param choices the collection of choices in the dropdown
	 * @param renderer the rendering engine
	 */
	public DropDownList(String id, IModel<? extends List<? extends T>> choices, IChoiceRenderer<? super T> renderer)
	{
		super(id, choices, renderer);
	}

	/**
	 * Constructor
	 * @param id the markup id
	 * @param model the {@link IModel}
	 * @param choices the collection of choices in the dropdown
	 * @param renderer the rendering engine
	 */
	public DropDownList(String id, IModel<T> model, IModel<? extends List<? extends T>> choices, IChoiceRenderer<? super T> renderer)
	{
		super(id, model, choices, renderer);
	}


	// Properties //
	/**
	 * Gets the (inner) list width.
	 * @return the list width
	 */
	public int getListWidth()
	{
		return this.width;
	}

	/**
	 * Sets the (inner) list width.
	 * @param width the list width
	 * @return this, for chaining
	 */
	public DropDownList<?> setListWidth(int width)
	{
		this.width = width;

		return this;
	}


	// Events //
	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(JQueryWidget.newWidgetBehavior(this));
	}

	@Override
	public void onConfigure(JQueryBehavior behavior)
	{
		if (this.getListWidth() > 0)
		{
			behavior.setOption("open", String.format("function(e) { e.sender.list.width(%d); }", this.getListWidth()));
		}
	}

	@Override
	public void onBeforeRender(JQueryBehavior behavior)
	{
	}

	// IJQueryWidget //
	@Override
	public JQueryBehavior newWidgetBehavior(String selector)
	{
		return new KendoAbstractBehavior(selector, DropDownList.METHOD);
	}
}

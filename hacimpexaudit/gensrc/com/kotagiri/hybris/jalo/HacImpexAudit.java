/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at May 22, 2020, 1:59:17 PM                    ---
 * ----------------------------------------------------------------
 */
package com.kotagiri.hybris.jalo;

import de.hybris.platform.directpersistence.annotation.SLDSafe;
import de.hybris.platform.impex.jalo.ImpExMedia;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.user.User;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type HacImpexAudit.
 */
@SLDSafe
@SuppressWarnings({"unused","cast"})
public class HacImpexAudit extends GenericItem
{
	/** Qualifier of the <code>HacImpexAudit.user</code> attribute **/
	public static final String USER = "user";
	/** Qualifier of the <code>HacImpexAudit.media</code> attribute **/
	public static final String MEDIA = "media";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(USER, AttributeMode.INITIAL);
		tmp.put(MEDIA, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HacImpexAudit.media</code> attribute.
	 * @return the media
	 */
	public ImpExMedia getMedia(final SessionContext ctx)
	{
		return (ImpExMedia)getProperty( ctx, "media".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HacImpexAudit.media</code> attribute.
	 * @return the media
	 */
	public ImpExMedia getMedia()
	{
		return getMedia( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HacImpexAudit.media</code> attribute. 
	 * @param value the media
	 */
	public void setMedia(final SessionContext ctx, final ImpExMedia value)
	{
		setProperty(ctx, "media".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HacImpexAudit.media</code> attribute. 
	 * @param value the media
	 */
	public void setMedia(final ImpExMedia value)
	{
		setMedia( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HacImpexAudit.user</code> attribute.
	 * @return the user
	 */
	public User getUser(final SessionContext ctx)
	{
		return (User)getProperty( ctx, "user".intern());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HacImpexAudit.user</code> attribute.
	 * @return the user
	 */
	public User getUser()
	{
		return getUser( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HacImpexAudit.user</code> attribute. 
	 * @param value the user
	 */
	public void setUser(final SessionContext ctx, final User value)
	{
		setProperty(ctx, "user".intern(),value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HacImpexAudit.user</code> attribute. 
	 * @param value the user
	 */
	public void setUser(final User value)
	{
		setUser( getSession().getSessionContext(), value );
	}
	
}

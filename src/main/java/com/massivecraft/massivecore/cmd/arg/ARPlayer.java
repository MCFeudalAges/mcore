package com.massivecraft.massivecore.cmd.arg;

import org.bukkit.entity.Player;

import com.massivecraft.massivecore.store.SenderIdSource;
import com.massivecraft.massivecore.store.SenderIdSourceMixinAllSenderIds;
import com.massivecraft.massivecore.util.IdUtil;

public class ARPlayer extends ARSenderIdAbstractPredsource<Player>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static final ARPlayer full = getFull(SenderIdSourceMixinAllSenderIds.get());
	public static ARPlayer getFull() { return full; }
	
	private static final ARPlayer start = getStart(SenderIdSourceMixinAllSenderIds.get());
	public static ARPlayer getStart() { return start; }
	
	public static ARPlayer getFull(SenderIdSource source)
	{
		return new ARPlayer(source, "player", ArgPredictateStringEqualsLC.get());
	}
	
	public static ARPlayer getStart(SenderIdSource source)
	{
		return new ARPlayer(source, "player", ArgPredictateStringStartsLC.get());
	}
	
	private ARPlayer(SenderIdSource source, String typename, ArgPredictate<String> argPredictate)
	{
		super(source, typename, argPredictate);
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public Player getResultForSenderId(String senderId)
	{
		return IdUtil.getPlayer(senderId);
	}

}

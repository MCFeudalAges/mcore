package com.massivecraft.massivecore.cmd.arg;

import org.bukkit.command.CommandSender;

import com.massivecraft.massivecore.SoundEffect;
import com.massivecraft.massivecore.util.Txt;

public class ARSoundEffect extends ArgReaderAbstract<SoundEffect>
{
	// -------------------------------------------- //
	// INSTANCE & CONSTRUCT
	// -------------------------------------------- //
	
	private static ARSoundEffect i = new ARSoundEffect();
	public static ARSoundEffect get() { return i; }
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public ArgResult<SoundEffect> read(String arg, CommandSender sender)
	{
		ArgResult<SoundEffect> ret = new ArgResult<SoundEffect>();
		
		try
		{
			ret.setResult(SoundEffect.valueOf(arg));
		}
		catch (Exception e)
		{
			ret.setErrors(Txt.parse("<b>") + e.getMessage());
		}
		return ret;
	}
	
}

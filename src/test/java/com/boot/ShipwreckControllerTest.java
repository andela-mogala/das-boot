package com.boot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGet() {
		Shipwreck sw = new Shipwreck();
		sw.setId(1l);
		when(shipwreckRepository.findOne(1l)).thenReturn(sw);
		
		Shipwreck wreck = sc.get(1l);
//		assertEquals(1L, wreck.getId().longValue());
		assertThat(wreck.getId(), is(1l));
	}
	
//	@Test
//	public void testShipwreckDelete() {
//		Shipwreck wreck = new Shipwreck();
//		wreck.setId(1l);
//		
//		when(shipwreckRepository.findOne(1l)).thenReturn(wreck);
//		when(shipwreckRepository.delete(wreck)).thenReturn();
//		
//		assertEquals(sc.delete(1l), wreck);
//	}
	
	@Test
	public void testShipwreckList() {
		List<Shipwreck> wrecks = new ArrayList<Shipwreck>();
		wrecks.add(new Shipwreck());
		wrecks.add(new Shipwreck());
		wrecks.add(new Shipwreck());
		
		when(shipwreckRepository.findAll()).thenReturn(wrecks);
		
		assertEquals(wrecks, sc.list());
	}
	
	@Test
	public void testShipwreckCreate() {
		Shipwreck wreck = new Shipwreck();
		wreck.setId(2l);
		wreck.setName("Atlantis");
		
		when(shipwreckRepository.saveAndFlush(wreck)).thenReturn(wreck);
		
		assertEquals(wreck, sc.create(wreck));
		assertEquals(wreck.getName(), sc.create(wreck).getName());
		assertEquals(wreck.getId(), sc.create(wreck).getId());
	}
	
	@Test
	public void testShipwreckUpdate() {
		Shipwreck wreck = new Shipwreck();
		wreck.setId(1l);
		wreck.setName("Emperor");
		
		Shipwreck updateShipwreck = new Shipwreck();
		updateShipwreck.setName("Enterprise");
		updateShipwreck.setId(1l);
		
		when(shipwreckRepository.findOne(1l)).thenReturn(wreck);
		when(shipwreckRepository.saveAndFlush(wreck)).thenReturn(updateShipwreck);
		
		Shipwreck sampleShipwreck = new Shipwreck();
		sampleShipwreck.setName("Enterprise");
		
		Shipwreck response = sc.update(1l, sampleShipwreck);
		assertEquals(response.getName(), updateShipwreck.getName());
		assertEquals(response.getId(), updateShipwreck.getId());
	}
}
